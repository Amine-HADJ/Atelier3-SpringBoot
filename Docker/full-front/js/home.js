document.addEventListener("DOMContentLoaded", async () => {
    cards = await fetch("../json/cardMarket.json").then((response) => response.json());

    await fetch("/card/generateCards", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cards)
    }).then(async (response) => console.log(await response.text()));


    await fetch("/card/ok", { 
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cards)
    }).then(async (response) => {
        if (response.ok) {
            console.log(await response.text());
        } else {
            console.error('HTTP-Error: ' + response.status);
        }
    }).catch((error) => {
        console.error('Fetch error:', error);
    });
});
