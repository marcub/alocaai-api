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
                            "recursos": ["projetor", "quadroVidro"],
                            "ambienteSalaAdequado": "Sala Comum"
                        },
                        "horario": {
                            "inicio": "08:00",
                            "fim": "10:00",    
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
                            "recursos": ["projetor", "ar", "quadroVidro"],
                            "ambienteSalaAdequado": "Laboratório"
                        },
                        "horario": {
                            "inicio": "10:00",
                            "fim": "12:00",
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
                        "projetor": 1,
                        "quadroVidro": 0,
                        "bloco": "Bloco 100"
                    },
                    {
                        "nome": "T-106",
                        "ambiente": "Laboratório",
                        "ar": 0,
                        "ventilador": 1,
                        "capacidade": 31,
                        "projetor": 1,
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
                    "qtdAlunos": 25,
                    "periodo": 1,
                    "disciplina": {
                        "nome": "Teoria da Computação",
                        "recursos": ["projetor", "quadroVidro"],
                        "ambienteSalaAdequado": "Sala Comum"
                    },
                    "horario": {
                        "inicio": "08:00",
                        "fim": "10:00",    
                        "diaSemana": "Segunda",
                        "turno": "Manhã"
                    },
                    "curso": {
                        "nome": "Engenharia de Software"
                    },
                    "sala": {
                        "nome": "T-105",
                        "ambiente": "Sala Comum",
                        "ar": 0,
                        "ventilador": 1,
                        "capacidade": 31,
                        "projetor": 1,
                        "quadroVidro": 0,
                        "bloco": "Bloco 100"
                    }
                },
                {
                    "qtdAlunos": 30,
                    "periodo": 1,
                    "disciplina": {
                        "nome": "Laboratório de Software I",
                        "recursos": ["projetor", "ar", "quadroVidro"],
                        "ambienteSalaAdequado": "Laboratório"
                    },
                    "horario": {
                        "inicio": "10:00",
                        "fim": "12:00",
                        "diaSemana": "Terça",
                        "turno": "Manhã"
                    },
                    "curso": {
                        "nome": "Engenharia de Software"
                    },
                    "sala": {
                        "nome": "T-106",
                        "ambiente": "Laboratório",
                        "ar": 0,
                        "ventilador": 1,
                        "capacidade": 31,
                        "projetor": 1,
                        "quadroVidro": 0,
                        "bloco": "Bloco 100"
                    }
                }
            ]






