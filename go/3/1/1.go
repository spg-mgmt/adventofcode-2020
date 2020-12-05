package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strings"
)

func main() {
	file, err := os.Open("../data.txt")
	if err != nil {
		log.Fatal(err)
	}

	data, err := ioutil.ReadAll(file)
	if err != nil {
		log.Fatal(err)
	}

	lines := strings.Split(string(data), "\n")

	var count int = 0
	var pos int = 0

	for i := 0; i < len(lines); i++ {
		linespart := strings.Split(string(lines[i]), "")
		target := "#"
		if pos >= len(linespart) {
			pos = pos % len(linespart)
		}
		if linespart[pos] == target {
			count++
		}
		pos += 3

	}
	fmt.Println(count)
}
