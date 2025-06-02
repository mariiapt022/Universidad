@ Ejemplo 4: ejemplos de bucle de espera de longitud práctica
@ Compatibilidad: Sólo ARMSim 1.9.1
@ Este ejemplo carga con direccionamiento inmediato en r0 el valor a visualizar en el display
@ Adicionalmente, el ejemplo introduce también un bucle de espera entre visualizaciones consecutivas
@ El bucle de espera utiliza direccionamiento inmediato para cargar el valor del retardo y el operando de la substracción
@ Al usar MOV con direccionamiento inmediato, el valor máximo de la costante de retardo es 0xFF (255), 
@ así que se multiplica r2 por 8 (haciendo 8 desplazamientos lógicos a izquierda) para obtener 0xFF00 (65280), y de esa forma
@ poder ver la representación de los dígitos en el display sin tener que usar ejecución paso a paso


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


.text
.global main

main:
		mov r0,#CERO		@ Carga en r0 el patrón de segmentos a iluminar para el dígito cero
		swi 0x200			@ Representa en el display de 7 segmentos el patrón de bits cargado en r0
		mov r2, #0xFF		@ Carga en r2 el valor del retardo a esperar (255 = 0xFF)
		mov r2, r2, lsl #8	@ Multiplicamos por 8 el valor para obtener 0xFF00 
		add r2,r2, #0xFF		@Conseguidmos r2=FFFF=65535
		
bucle:	subS r2, r2, #1		@ Bucle de espera. Vamos restando 1 al valor del contador r2. Notar la "S" para actualizar los flags 
							@ El usar un bucle decreciente permite ahorrarnos una instrucción de comparación en cada iteración 
							@ ya que el flag Z es actualizado por la propia resta del bucle
		bNE bucle			@ Salimos del bucle de retardo al llegar a 0
		
		mov r0,#UNO			@ Ahora, repetimos la secuencia completa para el dígito uno
		swi 0x200		
		mov r2, #0xFF
		mov r2, r2, lsl #8
		add r2,r2, #0xFF		@Conseguidmos r2=FFFF=65535
		
bucle2:	subS r2, r2, #1
		bNE bucle2			@ Salimos del bucle de retardo al llegar a 0. Observar que no podemos reutilizar el bucle anterior
		
		mov r0,#DOS			@ Ahora, repetimos la secuencia completa para el dígito dos
		swi 0x200		
		mov r2, #0xFF
		mov r2, r2, lsl #8
		add r2,r2,#0xFF		@Conseguidmos r2=FFFF=65535
		
bucle3:	subS r2, r2, #1
		bNE bucle3					

fin:	bx lr				@ termina el programa