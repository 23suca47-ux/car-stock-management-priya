const apiUrl = "http://localhost:8081/api/cars";

let editingId = null;

document.addEventListener("DOMContentLoaded", loadCars);

function loadCars() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("carTableBody");
            table.innerHTML = "";

            data.forEach(car => {
                const row = `
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.brand}</td>
                        <td>${car.model}</td>
                        <td>${car.price}</td>
                        <td>${car.quantity}</td>
                        <td>
                            <button onclick="editCar(${car.id}, '${car.brand}', '${car.model}', ${car.price}, ${car.quantity})">Edit</button>
                            <button onclick="deleteCar(${car.id})">Delete</button>
                        </td>
                    </tr>
                `;
                table.innerHTML += row;
            });
        });
}

function saveCar() {
    const brand = document.getElementById("brand").value;
    const model = document.getElementById("model").value;
    const price = parseFloat(document.getElementById("price").value);
    const quantity = parseInt(document.getElementById("quantity").value);

    const carData = { brand, model, price, quantity };

    if (editingId === null) {
        fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(carData)
        }).then(() => {
            loadCars();
            clearForm();
        });
    } else {
        fetch(`${apiUrl}/${editingId}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(carData)
        }).then(() => {
            loadCars();
            clearForm();
            editingId = null;
        });
    }
}

function editCar(id, brand, model, price, quantity) {
    document.getElementById("brand").value = brand;
    document.getElementById("model").value = model;
    document.getElementById("price").value = price;
    document.getElementById("quantity").value = quantity;

    editingId = id;
}

function deleteCar(id) {
    fetch(`${apiUrl}/${id}`, {
        method: "DELETE"
    }).then(() => loadCars());
}

function clearForm() {
    document.getElementById("brand").value = "";
    document.getElementById("model").value = "";
    document.getElementById("price").value = "";
    document.getElementById("quantity").value = "";
}
