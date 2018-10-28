find . -depth -name "*.java" > sources.txt #найти все сорсы и записать их в файл
find . -depth -name "*.class" -delete #удалить все старые бинарники
javac -d . -sourcepath @sources.txt #скомпилить
java Simulator $1 #запустить