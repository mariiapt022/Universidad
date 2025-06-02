.data
tam: .word 8
datos: .word 8,3,4,2,5,7,3,1
resul: .word 0,0,0,0,0,0,0,0

.text
.global main
main:
		ldr r0,=tam
		ldr r0,[r0]
		ldr r2,=datos
		ldr r3,=resul
		mov r4,#28
		
		bucle: 
		ldr r3,[r2,r4]
		sub r4,r4,#4
		subS r0,r0,#1
		bNE bucle
				
		salir:
		bx lr
		