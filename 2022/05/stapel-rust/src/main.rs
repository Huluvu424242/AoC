use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;


fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
    where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}


fn main() {
    let stacks: [Stack<char>; 9] = [Stack::new(),Stack::new(),Stack::new(),Stack::new(),Stack::new(),Stack::new(),Stack::new(),Stack::new(),Stack::new()];
    if let Ok(lines) = read_lines("../demo-input.txt") {
        for (line_nr, line) in lines.enumerate() {
            let zeile=&line.unwrap();
            let len = &zeile.len();
            // 1. Zeile prüfen
            if line_nr == 0 {
                // let NINE:usize=9;
                if len.eq( &9){
                    println!("9 Stacks gefunden");
                }else{
                    eprintln!("{} Stacks gefunden aber erwartet 9",len);
                }
            } else if line_nr < 10{
                // Stacks aufbauen
                println!(">{}<", zeile);
            } else {
                // Bewegen
            }
            println!("{}\t>{}<", line_nr, zeile);
        }
        // let mut stack: Stack<isize> = Stack::new();
        // stack.push(1);
        // let item = stack.pop();
        // assert_eq!(item.unwrap(), 1);
    } else {
        println!("read_lines goes wrong");
    }
}

/////// Stack geklaut von: https://www.kirillvasiltsov.com/writing/how-to-write-a-stack-in-rust/
// geklaut weil ich für solche Standardprobleme eine Implementierung in einer Standard Bibliothek erwarte
struct Stack<T> {
    stack: Vec<T>,
}

impl<T> Stack<T> {
    fn new() -> Self {
        Stack { stack: Vec::new() }
    }

    fn pop(&mut self) -> Option<T> {
        self.stack.pop()
    }

    fn push(&mut self, item: T) {
        self.stack.push(item)
    }

    fn is_empty(&self) -> bool {
        self.stack.is_empty()
    }

    fn length(&self) -> usize {
        self.stack.len()
    }

    fn peek(&self) -> Option<&T> {
        self.stack.last()
    }
}


// einfache anzeige des datei inhaltes
fn demo_ausgabe(lines: io::Lines<io::BufReader<File>>) {
    for line in lines {
        println!(">{}<", line.unwrap());
    }
}


fn part_contains_range(from1: i64, to1: i64, from2: i64, to2: i64) -> u64 {
    if from1 > to1 || from2 > to2 {
        println!("########### Da ist was faul ############\n [{}-{}] [{}-{}]\n########################################", from1, to1, from2, to2);
    }
    if (to2 >= from1 && to2 <= to1) || (from2 >= from1 && from2 <= to1)
        || (to1 >= from2 && to1 <= to2) || (from1 >= from2 && from1 <= to2) {
        return 1;
    } else {
        return 0;
    }
}

fn full_contains_range(from1: i64, to1: i64, from2: i64, to2: i64) -> u64 {
    if from1 > to1 || from2 > to2 {
        println!("########### Da ist was faul ############\n [{}-{}] [{}-{}]\n########################################", from1, to1, from2, to2);
    }
    if (from1 >= from2 && to1 <= to2) || (from2 >= from1 && to2 <= to1) {
        return 1;
    } else {
        return 0;
    }
}

fn read_ranges(line: io::Result<String>) -> (i64, i64, i64, i64) {
    if let Ok(zeile) = line {
        let mut linesplit = zeile.split(",");
        let leftside = linesplit.next();
        let rightside = linesplit.next();
        let mut leftsplit = leftside.unwrap().split('-');
        let mut rightsplit = rightside.unwrap().split('-');
        let from1 = leftsplit.next().unwrap().parse::<i64>().unwrap();
        let to1 = leftsplit.next().unwrap().parse::<i64>().unwrap();
        let from2 = rightsplit.next().unwrap().parse::<i64>().unwrap();
        let to2 = rightsplit.next().unwrap().parse::<i64>().unwrap();

        return (from1, to1, from2, to2);
    } else {
        return (0, 0, 0, 0);
    }
}
