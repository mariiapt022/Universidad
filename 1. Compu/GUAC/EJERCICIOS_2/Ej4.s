@ Ejemplo 6: uso de direccionamiento relativo post-indexado para recorrer un array
@ Compatibilidad: Sólo ARMSim 1.9.1
@ Este ejemplo crea un array en memoria con los dígitos del cero al nueve,
@ y usa direccionamiento relativo, empleando como base el registro r1, para irlos cargando
@ por orden en el registro r0 e irlos mostrando en el display de 7 segmentos
@ Tras mostrar cada dígito se usa el registro r3 para crear un bucle de retardo
@ El valor del retardo a esperar se carga también desde memoria, y puede por tanto 
@ tomar valores de hasta 32 bits; en este caso, se emplea como retardo 0xFFFF (65535). 


.equ CERO,0xED
.equ UNO, 0x60
.equ DOS, 0xCE
.equ TRES, 0xEA
.equ CUATRO, 0x63
.equ CINCO, 0xAB
.equ SEIS, 0x2F
.equ SIETE, 0xE0
.equ OCHO, 0xEF
.equ NUEVE, 0xE3

@ Creamos la sección de datos, para guardar las variables
.data
retardo: .word 0xFFFF		@ Longitud del bucle de retardo a esperar tras cada dígito
digitos: .word CERO, UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE    @ Array con los patrones de bits a representar


.text
.global main

main:
		ldr r1, =digitos	@ Carga en r1 la posición inicial del array de valores a representar
		mov r2, #10			@ Variable del bucle de control, con el número de dígitos a representar
		ldr r1, [r1], #36
bucle1:	ldr r0, [r1]
		sub r1,r1,#4		@ Bucle que va cargando en el registro r0 el valor a representar. r1 se incrementa tras su uso
							@ Como el array es de elementos de tamaño palabra, hay que incrementar la dirección en r1 de 4 en 4 bytes
		swi 0x200			@ Representa en el display de 7 segmentos el patrón de bits cargado en r0
		ldr r3, =retardo	@ Cargamos de memoria el valor del retardo a esperar. 
							@ Al estar en una variable de memoria, podemos usar valores de hasta 32 bits
							@ Además, el retardo podría variarse dinámicamente durante la ejecución del programa
		ldr r3, [r3]		@ Inicializamos r3 con el valor del retardo. Observar que se ha reutilizado r3.
bucle2:	subS r3, r3, #1		@ El usar un bucle decreciente permite ahorrarnos una instrucción de comparación en cada iteración
		bNE bucle2			@ Salimos del bucle de retardo al llegar a 0
		subS r2, r2, #1		@ Bucle de control del número de dígitos que restan por mostrar
		bNE	bucle1			@ De nuevo, usamos un bucle decreciente para ahorrarnos una comparación
		
fin:	bx lr				@ termina el programa