#lang reader "goto-reader.rkt"
10 X = 10
20 Z = 0
30 Y = 0
40 Z = Y * Y
50 IF Z <= X THEN GOTO 90 ELSE GOTO 60
60 Y = Y - 1
70 PRINT Y
80 RETURN
90 Y = Y + 1
100 GOTO 40 


