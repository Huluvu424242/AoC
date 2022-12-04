use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;
// use std::str;


fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
    where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}


fn main() {
    let mut sum_containments: u64 = 0;
    if let Ok(lines) = read_lines("../demo-input.txt") {
        for line in lines {
            let (from1, to1, from2, to2) = read_ranges(line);
            sum_containments += contains_range(from1, to1, from2, to2);
            println!("[{} bis {}] und [{} bis {}]", from1, to1, from2, to2);
        }
        println!("Es wurden {} enthaltene Bereiche gefunden.",sum_containments);
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

fn contains_range(from1: i64, to1: i64, from2: i64, to2: i64) -> u64 {
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
