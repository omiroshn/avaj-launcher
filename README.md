# avaj-launcher
 A minimal aircraft simulation program based on a given UML class diagram.

### How to launch:
```
make
java avaj.simulator.Simulator scenario.txt && cat simulation.txt
```
MD5 encryption is optional bonus.

Before launching you need to encrypt your file and take hash from it.
```
java avaj.simulator.Simulator scenario.txt "7b2a05f42fd2cc1ae53786d797eb2ba9" && cat simulation.txt
```

### Map (example) :
```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

### Bonuses :
- [x] Custom exceptions
- [x] MD5 encryption

## P.S.:
I'm not an expert, but MD5 does not encode things. it takes an input (a string or a file) and generates a 128 bit string, called the digest. it doesn't matter if you input 1 character or a million, the output is 128 bits. 

This is used to verify file integrity. I say "i am sending you this file. Here is the digest." When you get the file, you can run it through MD5 and then compare the digest you get to the one i sent. If they are the same, you can be pretty sure the file is unchanged. If the digest are different, then something has been changed in the source file, so you know the data is compromised. 

There is no way to take the digest and re-generate the original source. That is not what it is designed to do.

#                        **  Message to 42 students  **
You are free to copy, modify and share under your name my exercises. But you
will learn nothing, or will have the impression to understand without be able
to do it again alone. Be responsible and simply ask for help.

                                                                         omiroshn
