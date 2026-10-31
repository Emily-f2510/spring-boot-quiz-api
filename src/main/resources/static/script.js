const API_URL = "http://localhost:8081/cerinte";

async function callAPI(endpoint, tableId) {
    try {
        const response = await fetch(`${API_URL}/${endpoint}`);
        const data = await response.json();
        const table = document.getElementById(tableId);
        table.innerHTML = "";

        if (!data || data.length === 0) {
            table.innerHTML = "<tr><td style='color:#ad1457; padding:20px;'>Nu există date (Verifică dacă ai Testul 4 și date din 2025 în baza de date).</td></tr>";
            return;
        }


        let headers = [];
        if (endpoint === '3a') headers = ["ID Întrebare", "Var.", "Text Răspuns", "Corect?"];
        else if (endpoint === '3b') headers = ["ID Test", "Data Test"];
        if (endpoint === '4a') {
            headers = ["Test", "Întrebare", "Răspuns Model", "Răspuns Dat"];}
        else if (endpoint === '4b') headers = ["ID Test 1", "ID Test 2"];
        if (endpoint === '5a') {
            headers = ["Răspunsuri Valide (Corecte) - Test 1"];
        }
        // În script.js, în interiorul funcției callAPI:
        if (endpoint === '5b') {
            headers = ["ID Teste Completate (Toate răspunsurile date)"];
        }
        else if (endpoint === '6a') headers = ["ID Test", "Număr Întrebări", "Punctaj Total"];
        else if (endpoint === '6b') headers = ["ID Întrebare", "Media Punctajelor (Raport Maxim)"];

        const thead = document.createElement("thead");
        const hRow = document.createElement("tr");
        headers.forEach(text => {
            const th = document.createElement("th");
            th.textContent = text;
            hRow.appendChild(th);
        });
        thead.appendChild(hRow);
        table.appendChild(thead);

        const tbody = document.createElement("tbody");
        data.forEach(row => {
            const tr = document.createElement("tr");
            const values = Array.isArray(row) ? row : Object.values(row);
            values.forEach(val => {
                const td = document.createElement("td");
                td.textContent = val;
                tr.appendChild(td);
            });
            tbody.appendChild(tr);
        });
        table.appendChild(tbody);
    } catch (err) {
        alert("Eroare legătură server!");
    }
}