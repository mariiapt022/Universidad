#include <stdio.h>
#include <stdlib.h>
#include "userList.h"

T_user * createUser(char *name, int uid, char *dir){
    T_user *usr = malloc(sizeof(struct user));
    if (usr == NULL)
    {
        perror("No hay sufiente memoria disponible");
        exit(-1);
    }else
    {
        usr->userName_ = name;
        usr->uid_ = uid;
        usr->homeDirectory_ = dir;
        usr->previousUser_ = NULL;
        usr->nextUser_ = NULL;
    }  
}

T_userList createUserList(){
    T_userList *list = malloc(sizeof(struct userList));
    if (list == NULL)
    {
        perror("No hay sufiente memoria disponible");
        exit(-1);
    }else
    {
        list->head_ = NULL;
        list->tail_ = NULL;
        list->numberOfUsers_ = 0;
    }
    return *list;   
}
int addUser(T_userList *list, T_user *user){
    int ok = 0;
    if (list->tail_ == NULL)
    {
        ok = 1;
        list->head_ = user;
        list->tail_ = user;
        list->numberOfUsers_ = 1;
    }else
    {
        T_user *ptr = list->tail_;
        while (ptr != NULL && ptr != user)
        {
            ptr = ptr->previousUser_;
        }
        if(ptr == NULL){
            ok = 1;
            list->head_->previousUser_ = user;
            user->nextUser_ = list->head_;
            list->head_ = user;
            list->numberOfUsers_ ++;
        }
    }
    return ok;
}

int getUid(T_userList list, char *userName){
    int id = -1;
    if (list.head_ != NULL)
    {
        T_user *ptr = list.head_;
        while (ptr != NULL && strcmp(ptr->userName_,userName) != 0)
        {
            ptr = ptr->nextUser_;
        }
        
        if (ptr != NULL)
        {
            id = ptr->uid_;
        }
        
    }
    return id;
}
int deleteUser(T_userList *list, char* userName){
    int ok = -1;
    if (list == NULL)
    {
        printf("Lista vacía\n");
    }else
    {
        T_user *ptr = list->head_;
        while (ptr != NULL && strcmp(ptr->userName_,userName) != 0)
        {
            ptr = ptr->nextUser_;
        }
        if (ptr != NULL)
        {
            ok = 0;
            if (ptr->nextUser_ == NULL && ptr->previousUser_ == NULL)
            {
                list->head_ = NULL;
                list->tail_ = NULL;
            }else if (ptr->nextUser_ == NULL)
            {
                list->tail_ = ptr->previousUser_;
                list->tail_->nextUser_ = NULL;
            }else if (ptr->previousUser_ == NULL)
            {
                list->head_ = ptr->nextUser_;
                list->head_->previousUser_ = NULL;
            }else{
                ptr->previousUser_->nextUser_ = ptr->nextUser_;
                ptr->nextUser_->previousUser_ = ptr->previousUser_;
            }
            free(ptr);
        }    
    }
    return ok;
}

void printUserList(T_userList list, int reverse){
    if (reverse == 0)
    {
        printf("Lista de usuarios desde la cabeza: ");
        T_user *ptr = list.head_;
        while (ptr != NULL)
        {
            printf("%s|%i|%s ",ptr->homeDirectory_,ptr->uid_,ptr->userName_);
            ptr = ptr->nextUser_;
        }
    }else{
        printf("Lista de usuarios desde la cola: ");
        T_user *ptr = list.tail_;
        while (ptr != NULL)
        {
            printf("%s|%i|%s ",ptr->homeDirectory_,ptr->uid_,ptr->userName_);
            ptr = ptr->previousUser_;
        }
    }
    printf("\n");
}

