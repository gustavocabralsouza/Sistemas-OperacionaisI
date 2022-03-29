import copy
import threading
from time import sleep, time

colocados = []


class F1(threading.Thread):
    def __init__(self, escudeira):
        threading.Thread.__init__(self)
        self.semaforo = threading.Semaphore(5)
        self.semaforoCarro = threading.Semaphore(1)
        self.escudeira = escudeira

    def run(self) -> None:
        try:
            self.semaforo.acquire()
            match self.escudeira:
                case 1:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 2:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 3:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 4:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 5:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 6:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
                case 7:
                    self.semaforoCarro.acquire()
                    for i in range(3):
                        self.volta()
                        if i == 2:
                            colocados.append(self.escudeira)
                            colocados.append(max(self.tempos))
                    self.semaforoCarro.release()
            self.semaforo.release()
        except Exception as e:
            print(e)
        finally:
            self.semaforo.release()

    def volta(self):
        # try:
        #     self.semaforoCarro.acquire()
        self.tempos = []
        tempo_ini = time()
        print(f"{self.native_id} da escudeira {self.escudeira} começou uma volta")
        sleep(5)
        print(f"{self.native_id} da escudeira {self.escudeira} terminou uma volta")
        self.tempos.append(time() - tempo_ini)
        #     self.semaforoCarro.release()
        # except Exception as e:
        #     print(e)
        # finally:
        #     self.semaforoCarro.release()


if __name__ == '__main__':
    escudeira = [1, 3, 2, 1, 3, 2, 7, 4, 5, 6, 5, 6, 4, 7]
    for i in escudeira:
        f1 = F1(i)
        f1.start()
    sleep(20)

    lista_auxiliar = [i for i in colocados if i is not int]
    print(lista_auxiliar)
    print(colocados)
    exit(0)
    for i in range(len(colocados)//2):
        print(f"{i+1}° colocado, {colocados[colocados.index(lista_auxiliar[i])-1]}")

    print(colocados)
