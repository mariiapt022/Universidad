@María Peinado Toledo
.data
tam:        .word 8
vect:       .word 64,25,9,23,56,77,87,100
res:        .word 0
.text
.global main
main:       push {lr}
            ldr r0, =vect          	@ Cargamos direccion del vector en r0
            ldr r1, =tam          
            ldr r1, [r1]           	@ Cargamos longitud del vector en r1
            ldr r4, =res           	@ Cargamos la direccion de res en r4
            bl evencount           	@ Invocamos funcion
            str r0, [r4]           	@ Guardamos el resultado en res
            pop {pc}  	
			bx lr					@ Finalizamos el programa
           
iseven:     @Codigo de la funcion que indica si un numero es par o no.
            @(Hay que llamarla desde evencount y no se puede modificar)
            mov r1, r0
            mov r2, #1
            and r3, r2, r1
            eor r0, r3, #1
            bx lr
 
evencount: push {r5-r7,lr}
	    mov r7,#0
	    ldr r5,[r0],#4
	    push {r0-r1,lr}
	    mov r0,r5
	    bl iseven
	    mov r7,r0
	    pop {r0-r1,lr}
         add r1,r1,#-1
	    loop:	cmp r1, #1
			blt fin
			ldr r5,[r0],#4
			push {r0-r1,lr}
			mov r0,r5
			bl iseven
			add r7,r7,r0
			pop {r0-r1,lr}
			add r1,r1,#-1
			b loop
	
			fin:	mov r0,r7
				pop {r5-r7,lr}
				bx lr
			
			
	    
	    
	    
	    












