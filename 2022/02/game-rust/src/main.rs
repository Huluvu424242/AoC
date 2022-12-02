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
    let mut points_left_elf = 0;
    let mut points_right_elf = 0;
    // // aktueller Durchlauf
    let mut cur_left_elf = "";
    let mut cur_right_elf = "";


    for line in lines {
        if let Ok(context) = line {
            let mut split = context.split_whitespace();
            cur_left_elf = split.next().unwrap();
            cur_right_elf = split.next().unwrap();
            println!("Elf links spielt: {}", cur_left_elf);
            println!("Elf rechts spielt: {}", cur_right_elf);
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
X für Stein, Y für Papier und Z für Schere
1 für Stein, 2 für Papier und 3 für Schere
(0, wenn Sie verloren haben, 3, wenn die Runde unentschieden war , und 6 wenn du gewonnen hast)
 */
fn punkte_berechnen(left_elf: &str, right_elf: &str) -> [u8; 2] {
    let mut points: [u8; 2] = [0, 0]; // default
    // beide Stein
    if left_elf == "A" && right_elf == "X" {
        points = [1 + 3, 1 + 3];
    }
    // beide Papier
    if left_elf == "B" && right_elf == "Y" {
        points = [2 + 3, 2 + 3];
    }
    // beide Schere
    if left_elf == "C" && right_elf == "Z" {
        points = [3 + 3, 3 + 3];
    }

    // Stein -> Papier
    if left_elf == "A" && right_elf == "Y" {
        points = [1 + 0, 2 + 6]
    }

    // Stein <- Schere
    if left_elf == "A" && right_elf == "Z" {
        points = [1 + 6, 3 + 0]
    }

    // Papier <- Stein
    if left_elf == "B" && right_elf == "X" {
        points = [2 + 6, 1 + 0]
    }

    // Papier -> Schere
    if left_elf == "B" && right_elf == "Z" {
        points = [2 + 0, 3 + 6]
    }

    // Schere -> Stein
    if left_elf == "C" && right_elf == "X" {
        points = [3 + 0, 1 + 6]
    }

    // Schere <- Papier
    if left_elf == "C" && right_elf == "Y" {
        points = [3 + 6, 2 + 0]
    }

    return points;
}

