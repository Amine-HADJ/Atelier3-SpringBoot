let cardList;

async function buyCard(id){
    await fetch("/market/buycard", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userId: localStorage.getItem("userId"),
            cardId: id,
        })
    }).then((response) => {
        if(!response.ok){
            alert("Couldn't buy card, check your wallet");
            return
        }
        window.location.href = "cardList-market-buy.html";
    });
}


function setCardlist(){
    setTemplate("#cardlist","#tableContent",cardList)
}

document.addEventListener("DOMContentLoaded", async () => {
    cardList = await fetch("/market/getmarket", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    }).then((response) => response.json());
    setCardlist();
});