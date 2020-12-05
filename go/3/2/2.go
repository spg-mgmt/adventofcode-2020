package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strings"
)

func countTrees(lines []string, goright int, godown int) int {
	var pos int = 0
	var count int = 0

	for i := 0; i < len(lines); i += godown {
		linespart := strings.Split(string(lines[i]), "")
		target := "#"
		if pos >= len(linespart) {
			pos = pos % len(linespart)
		}
		if linespart[pos] == target {
			count++
		}
		pos += goright
	}
	return count
}

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

	fmt.Println(countTrees(lines, 1, 1) * countTrees(lines, 3, 1) * countTrees(lines, 5, 1) * countTrees(lines, 7, 1) * countTrees(lines, 1, 2))
}
