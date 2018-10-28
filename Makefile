
all: clean
	find . -depth -name "*.java" > sources.txt #найти все сорсы и записать их в файл
	javac -d . -sourcepath @sources.txt #скомпилить
	java Simulator scenario.txt #запустить
clean:
	rm -rf ro
	rm -rf out
	rm -rf sources.txt
	find . -depth -name "*.class" -delete
