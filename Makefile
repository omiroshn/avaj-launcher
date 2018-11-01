
all: clean
	echo "comment" > sources.txt
	find . -depth -name "*.java" >> sources.txt #найти все сорсы и записать их в файл
	javac -d . -sourcepath @sources.txt #скомпилить
	java avaj.simulator.Simulator scenario.txt #запустить
clean:
	rm -rf avaj
	rm -rf out
	rm -rf sources.txt
	rm -rf simulation.txt
	find . -depth -name "*.class" -delete
