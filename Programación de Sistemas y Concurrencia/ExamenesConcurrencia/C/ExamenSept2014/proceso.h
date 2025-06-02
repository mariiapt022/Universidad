typedef struct proceso *LSistema;

typedef struct hebra *LHebra;

struct proceso
{
    int idproc;
    LSistema sig;
    LHebra hebra;
};

struct hebra
{
    char *idheb;
    int prior;
    LHebra sig;
};

void Crear (LSistema *ls);

void InsertarProceso ( LSistema *ls, int idproc);

void InsertarHebra (LSistema *ls, int idproc, char *idhebra, int
priohebra);

void Mostrar (LSistema ls);

void EliminarProc (LSistema *ls, int idproc);

void Destruir (LSistema *ls);

