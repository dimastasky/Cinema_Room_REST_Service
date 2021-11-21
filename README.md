# Cinema Room REST Service project

Hyperskill [Cinema Room REST Service](https://hyperskill.org/) project


- **GET /seats** - to get JSON with all seats and their status;
- **POST /purchase [row][column]** - to mark seat as purchased and get ticket's token;
- **POST /return [token]** - to return ticket and mark it ad available;
- **POST /stats [password]** - (password is "super_secret"). Return your cinema statistics, including:
    1. **current_income** — shows the total income of sold tickets.
    2. **number_of_available_seats** — shows how many seats are available.
    3. **number_of_purchased_tickets** — shows how many tickets were purchased.
