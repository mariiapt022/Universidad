.data
mynumel: .word 0
myvect: .word 0
myres: .word 0

.text
.global main
main:	push {lr}
		ldr r0,=myvect
		ldr r1,=mynumel
		ldr r1,[r1]
		bl abssum
		ldr r1,=myres
		str r0,[r1]
		pop {lr}
		mov pc, lr
		
abs: 	mov r1,#0
		cmp r0,r1
		sublt r0,r1,r0
		mov pc, lr
		
abssum:	push {lr}
		mov r3,#0
		ldr r4, =myvect
		bucle:	cmp r1,#0
		beq salir
		ldr r0,[r4],#4
		push {r1}
		bl abs
		pop {r1}
		add r3,r3,r0
		subS r1,r1,#1
		bNE bucle
		
		salir:
		mov r0,r3
		pop {lr}
		mov pc, lr