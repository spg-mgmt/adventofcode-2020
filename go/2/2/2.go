package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strconv"
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

	for i := 0; i < len(lines); i++ {
		lines[i] = strings.Replace(lines[i], "-", " ", -1)
		lines[i] = strings.Replace(lines[i], ":", "", -1)
	}

	var count int = 0

	for i := 0; i < len(lines); i++ {
		linespart := strings.Split(string(lines[i]), " ")
		pos1, _ := strconv.Atoi(linespart[0])
		pos2, _ := strconv.Atoi(linespart[1])
		target := linespart[2]
		teststr := linespart[3]

		pos1char := string(teststr[pos1-1])
		pos2char := string(teststr[pos2-1])

		if pos1char == target && pos2char != target {
			count++
		} else if pos1char != target && pos2char == target {
			count++
		}
	}
	fmt.Println(count)
}
