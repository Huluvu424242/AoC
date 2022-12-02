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
    if let Ok(lines) = read_lines("src/demo-input.txt") {
        //println!("===lines: {:?}", lines);
        spielen(lines);
    } else {
        println!("read_lines goes wrong");
    }
}

fn spielen(lines: io::Lines<io::BufReader<File>>) {
    let mut points_left_elf:u64 = 0;
    let mut points_right_elf:u64 = 0;
    // // aktueller Durchlauf
    let mut cur_left_elf = "";
    let mut cur_right_elf = "";


    for line in lines {
        if let Ok(context) = line {
            let mut split = context.split_whitespace();
            cur_left_elf = split.next().unwrap();
            cur_right_elf = split.next().unwrap();
            println!("Elf links spielt: {}", cur_left_elf);
            println!("Elf rechts Anweisung: {}", cur_right_elf);
            let points = punkte_berechnen(cur_left_elf, cur_right_elf);
            println!("Spielpunkte {} <--> {}", points[0], points[1]);
            points_left_elf += points[0];
            points_right_elf += points[1];
            println!("Zwischenstand: {} <==> {}", points_left_elf, points_right_elf);
        }
    }
    println!("Endstand {} <#####> {}", points_left_elf, points_right_elf);
}

/*
A für Stein, B für Papier und C für Schere
X für verlieren, Y unentschieden und Z für gewinnen
1 für Stein, 2 für Papier und 3 für Schere
(0, wenn Sie verloren haben, 3, wenn die Runde unentschieden war , und 6 wenn du gewonnen hast)
 */
fn punkte_berechnen(left_elf: &str, order_right_elf: &str) -> [u64; 2] {
    let mut points: [u64; 2] = [0, 0]; // default
    // Stein mit Order verlieren
    if left_elf == "A" && order_right_elf == "X" {
        // ich wähle Schere
        points = [1 + 6, 3 + 0];
    }
    // Stein mit Order unentschieden
    if left_elf == "A" && order_right_elf == "Y" {
        // ich wähle Stein
        points = [1 + 3, 1 + 3];
    }
    // Stein mit Order gewinnen
    if left_elf == "A" && order_right_elf == "Z" {
        // wähle Papier
        points = [1 + 0, 2 + 6];
    }

    // Papier mit Order verlieren
    if left_elf == "B" && order_right_elf == "X" {
        // ich wähle Stein
        points = [2 + 6, 1 + 0];
    }
    // Papier mit Order unentschieden
    if left_elf == "B" && order_right_elf == "Y" {
        // ich wähle Papier
        points = [2 + 3, 2 + 3];
    }
    // Papier mit Order gewinnen
    if left_elf == "B" && order_right_elf == "Z" {
        // wähle Schere
        points = [2 + 0, 3 + 6];
    }
///////////
    // Schere mit Order verlieren
    if left_elf == "C" && order_right_elf == "X" {
        // ich wähle Papier
        points = [3 + 6, 2 + 0];
    }
    // Schere mit Order unentschieden
    if left_elf == "C" && order_right_elf == "Y" {
        // ich wähle Schere
        points = [3 + 3, 3 + 3];
    }
    // Schere mit Order gewinnen
    if left_elf == "C" && order_right_elf == "Z" {
        // wähle Stein
        points = [3 + 0, 1 + 6];
    }
    return points;
}

