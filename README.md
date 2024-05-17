# Aloca API

O Aloca API é uma API RESTful que permite o processamento de alocação de disciplinas em salas utilizando heurísticas pré definidas.

## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |

# Recursos

### Gerar Solução Gulosa [POST /api/solucaoGulosa]

+ Request (application/json)

    + Headers

    + Body

            {
                "turmas": [
                    {
                        "qtdAlunos": 25,
                        "periodo": 1,
                        "disciplina": {
                            "nome": "Teoria da Computação",
                            "recursos": ["Projetor", "Quadro Branco"],
                            "ambienteSalaAdequado": "Sala Comum"
                        },
                        "horario": {
                            "horario": "08:00 - 10:00",
                            "diaSemana": "Segunda",
                            "turno": "Manhã"
                        },
                        "curso": {
                            "nome": "Engenharia de Software"
                        }
                    },
                    {
                        "qtdAlunos": 30,
                        "periodo": 1,
                        "disciplina": {
                            "nome": "Laboratório de Software I",
                            "recursos": ["Computador", "Quadro Branco", "Projetor"],
                            "ambienteSalaAdequado": "Laboratório"
                        },
                        "horario": {
                            "horario": "10:00 - 12:00",
                            "diaSemana": "Terça",
                            "turno": "Manhã"
                        },
                        "curso": {
                            "nome": "Engenharia de Software"
                        }
                    },
                ],
                "salas": [
                    {
                        "nome": "T-105",
                        "ambiente": "Sala Comum",
                        "ar": 0,
                        "ventilador": 1,
                        "capacidade": 31,
                        "quadroGiz": 1,
                        "quadroBranco": 0,
                        "quadroVidro": 0,
                        "bloco": "Bloco 100"
                    },
                    {
                        "nome": "T-106",
                        "ambiente": "Sala Comum",
                        "ar": 0,
                        "ventilador": 1,
                        "capacidade": 31,
                        "quadroGiz": 1,
                        "quadroBranco": 0,
                        "quadroVidro": 0,
                        "bloco": "Bloco 100"
                    }
                ]
            }


+ Response 200 (application/json)

    + Headers

    + Body

            [
                {
                    "qtdAlunos": 30,
                    "periodo": 3,
                    "disciplina": {
                        "nome": "Laboratório de Software III",
                        "recursos": [
                            "Computador",
                            "Quadro Branco",
                            "Projetor"
                        ],
                        "ambienteSalaAdequado": "Laboratório"
                    },
                    "horario": {
                        "horario": "08:00 - 09:50",
                        "diaSemana": "Terça",
                        "turno": "Manhã"
                    },
                    "curso": {
                        "nome": "Engenharia de Software"
                    },
                    "sala": {
                        "nome": "L-401",
                        "ambiente": "Laboratório",
                        "ar": 1,
                        "ventilador": 0,
                        "capacidade": 30,
                        "quadroGiz": 0,
                        "quadroBranco": 0,
                        "quadroVidro": 1,
                        "bloco": "Bloco 400"
                    }
                }
            ]






