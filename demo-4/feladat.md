1. DB entitások:
- Dog
  - id PK bigint
  - chipId UNIQUE varchar not null
  - name varchar not null
  - gender bit/varchar not null
  - shelter_id FK bigint
- Shelter
  - id PK bigint
  - address varchar not null
  - capacity integer not null

2. Validáció
- Dog
  - chipId: ABCDEF-09
  - name, gender not null
- Shelter
  - address, capacity not null

3. POST /api/shelter
   - példa input: `{ "address" : "string", capacity: 20 }`
   - példa output: `{ "id:" 1, "address" : "string", capacity: 20 }`
   - 201 Created
   - 400 Bad Request, ha már van ilyen menhely
4. GET /api/shelter
   - példa output: `[ { "id": 1, "address": "string", capacity: 20}, ... ]` 
5. GET /api/shelter/{id}
    - példa output: `{ "id": 1, "address": "string", capacity: 20}`
6. PUT /api/shelter/{id}
7. POST /api/dog
    - példa input: `{ "name": "string", "gender": "string", "chipId": "string", "shelter_id": 1 }`
    - példa output: `{ "id": 2, "name": "string", "gender": "string", "chipdId": "string", "shelter_id": 1 }`
    - 201 Created
    - 400 Bad Request, ha
      - helytelen a chipId formátuma
      - elértük a `capacity`-t
8. GET /api/dog
9. GET /api/dog/{id}
10. PUT /api/dog/{id}

- Legyen egy generikus `ErrorModel`ünk:
```json
{
  "error": {
    "message": "string"
  }
}
```
- Ugyanolyan címmel ne lehessen felvenni több menhelyet! Dobjunk ekkor *saját* exceptiont, 
amit egy `RestControllerAdvice` lekezel, és visszaad egy hibát!
- Ugyanolyan chipId-val ne lehessen felvenni több kutyát! Dobjunk ekkor *saját* exceptiont
amit egy `RestControllerAdvice` lekezel, és visszaad egy hibát!
- Ha elértük a `capacity`-t, ne engedjünk hozzáadni újabb kutyát! Ha elértük, dobjunk exceptiont,
amit a handler lekezel! 
