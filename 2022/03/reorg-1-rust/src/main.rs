use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
use std::str;


fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
    where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}


fn main() {
    if let Ok(lines) = read_lines("../demo-input.txt") {
        list_priorities();
        packen(lines);
    } else {
        println!("read_lines goes wrong");
    }
}

// einfache anzeige des datei inhaltes
fn demo_ausgabe(lines: io::Lines<io::BufReader<File>>) {
    for line in lines {
        println!(">{}<", line.unwrap());
    }
}

fn list_priorities() {
    let alpha = String::from("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    for (zeichen) in alpha.chars().into_iter() {
        if zeichen.is_uppercase() {
            println!("{} = {}", zeichen, zeichen as i64 - 38);
        } else {
            println!("{} = {}", zeichen, zeichen as u32 - 38 - 58);
        }
    }
}


fn packen(lines: io::Lines<io::BufReader<File>>) {
    let mut sum_priority:u64 =0;
    let mut i: i64 = 0;
    for line in lines {
        i += 1;
        let inhalt: String = line.unwrap();
        let rucksack = Rucksack::new(i, inhalt);
        rucksack.printout();
        sum_priority += rucksack.priority;
    }
    println!("Die Summe der Priorität beträgt: {}",sum_priority);
}


struct Rucksack {
    id: i64,
    compartment1: String,
    compartment2: String,
    eq_zeichen: String,
    priority: u64,
}

impl Rucksack {
    fn new(id: i64, inhalt: String) -> Rucksack {
        let len: usize = inhalt.len();
        let splitpoint: usize = (len / 2) as usize;
        let (left, right) = inhalt.split_at(splitpoint);
        let eq_str: String = Rucksack::get_equal_char(String::from(left), String::from(right));
        let eq_char: char = eq_str.chars().next().unwrap();
        let rucksack = Rucksack {
            id: id,
            compartment1: left.to_string(),
            compartment2: right.to_string(),
            eq_zeichen: eq_char.to_string(),
            priority: Rucksack::get_priority(eq_char),
        };
        return rucksack;
    }

    fn get_priority(zeichen: char) -> u64 {
        if zeichen.is_uppercase() {
            return zeichen as u64 - 38;
        } else {
            return zeichen as u64 - 38 - 58;
        }
    }

    fn get_equal_char(left: String, right: String) -> String {
        for (i, zeichen) in left.chars().into_iter().enumerate() {
            if right.contains(zeichen) {
                return String::from(zeichen);
            }
        }
        return String::from("");
    }

    fn printout(&self) {
        println!("\nRucksack {} enthält \n   links: {} \n  rechts: {} \n  eqChar: {} \n Priority: {}", self.id, self.compartment1, self.compartment2, self.eq_zeichen, self.priority);
    }
}


//
// fn spielen(lines: io::Lines<io::BufReader<File>>) {
//     let mut points_left_elf:u64 = 0;
//     let mut points_right_elf:u64 = 0;
//     // // aktueller Durchlauf
//     let mut cur_left_elf = "";
//     let mut cur_right_elf = "";
//
//
//     for line in lines {
//         if let Ok(context) = line {
//             let mut split = context.split_whitespace();
//             cur_left_elf = split.next().unwrap();
//             cur_right_elf = split.next().unwrap();
//             println!("Elf links spielt: {}", cur_left_elf);
//             println!("Elf rechts Anweisung: {}", cur_right_elf);
//             let points = punkte_berechnen(cur_left_elf, cur_right_elf);
//             println!("Spielpunkte {} <--> {}", points[0], points[1]);
//             points_left_elf += points[0];
//             points_right_elf += points[1];
//             println!("Zwischenstand: {} <==> {}", points_left_elf, points_right_elf);
//         }
//     }
//     println!("Endstand {} <#####> {}", points_left_elf, points_right_elf);
// }
//
// /*
// A für Stein, B für Papier und C für Schere
// X für verlieren, Y unentschieden und Z für gewinnen
// 1 für Stein, 2 für Papier und 3 für Schere
// (0, wenn Sie verloren haben, 3, wenn die Runde unentschieden war , und 6 wenn du gewonnen hast)
//  */
// fn punkte_berechnen(left_elf: &str, order_right_elf: &str) -> [u64; 2] {
//     let mut points: [u64; 2] = [0, 0]; // default
//     // Stein mit Order verlieren
//     if left_elf == "A" && order_right_elf == "X" {
//         // ich wähle Schere
//         points = [1 + 6, 3 + 0];
//     }
//     // Stein mit Order unentschieden
//     if left_elf == "A" && order_right_elf == "Y" {
//         // ich wähle Stein
//         points = [1 + 3, 1 + 3];
//     }
//     // Stein mit Order gewinnen
//     if left_elf == "A" && order_right_elf == "Z" {
//         // wähle Papier
//         points = [1 + 0, 2 + 6];
//     }
//
//     // Papier mit Order verlieren
//     if left_elf == "B" && order_right_elf == "X" {
//         // ich wähle Stein
//         points = [2 + 6, 1 + 0];
//     }
//     // Papier mit Order unentschieden
//     if left_elf == "B" && order_right_elf == "Y" {
//         // ich wähle Papier
//         points = [2 + 3, 2 + 3];
//     }
//     // Papier mit Order gewinnen
//     if left_elf == "B" && order_right_elf == "Z" {
//         // wähle Schere
//         points = [2 + 0, 3 + 6];
//     }
// ///////////
//     // Schere mit Order verlieren
//     if left_elf == "C" && order_right_elf == "X" {
//         // ich wähle Papier
//         points = [3 + 6, 2 + 0];
//     }
//     // Schere mit Order unentschieden
//     if left_elf == "C" && order_right_elf == "Y" {
//         // ich wähle Schere
//         points = [3 + 3, 3 + 3];
//     }
//     // Schere mit Order gewinnen
//     if left_elf == "C" && order_right_elf == "Z" {
//         // wähle Stein
//         points = [3 + 0, 1 + 6];
//     }
//     return points;
// }
//
