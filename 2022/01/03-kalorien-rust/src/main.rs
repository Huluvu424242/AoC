use std::fs::File;
use std::io::{self, BufRead};
use std::path::Path;


fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
where P: AsRef<Path>, {
    let file = File::open(filename)?;
    Ok(io::BufReader::new(file).lines())
}


fn main() {
    if let Ok(lines) = read_lines("src/input.txt") {
        // println!("===lines: {:?}", lines);
       auswertung(lines);
    }else{
        println!("read_lines goes wrong");
    }
}

fn auswertung(lines:io::Lines<io::BufReader<File>>){
    let mut max_elf_nr = 0;
    let mut max_elf_kalorien = 0;
    // aktueller Durchlauf
    let mut cur_elf_nr = 0;
    let mut cur_elf_kalorien = 0;


    for line in lines {
        if let Ok(context) = line {
            // println!("Elf Nr: {}",cur_elf_nr);
            let trimmed= context.trim();
            if trimmed.len()>0 {
                let my_int = trimmed.parse::<u64>().unwrap();
                // print!(">{}<", my_int);
                cur_elf_kalorien = cur_elf_kalorien + my_int;
                println!("  Elf Nr {}: lädt {} Kalorien", cur_elf_nr, my_int);
            }else{
                println!("### Elf Nr {}: trägt insgesamt {} Kalorien", cur_elf_nr, cur_elf_kalorien);
                if cur_elf_kalorien > max_elf_kalorien {
                    max_elf_kalorien = cur_elf_kalorien;
                    max_elf_nr = cur_elf_nr;
                }
                cur_elf_nr = cur_elf_nr+1;
                cur_elf_kalorien = 0;
            }
        }
    }
    println!("Das Essen mit den meisten Kalorien trägt Elf Nr {} mit insgesamt {} Kalorien", max_elf_nr, max_elf_kalorien);
}
