.data
tamdat: .word 15
datos: .word 2,4,2,8,2,4,2,7,5,6,5,3,7,6,8
res: .word 0

.text
.global main
main:
		push {lr}
		ldr r1,=datos
		ldr r2,=tamdat
		ldr r2,[r2]
		mov r0,#4 @n
		bl hist
		ldr r1,=res
		str r0,[r1]
		pop {lr}
		mov pc, lr
hist:
		push {r4}
		mov r3,r0
		mov r0,#0
		bucle: 
		ldr r4,[r1],#4
		subS r4,r4,r3
		bNE seguir
		add r0,r0,#1
		seguir:
		subS r2,r2,#1
		bNE bucle
		b salir
		
		salir: 
		pop {r4}
			bx lr