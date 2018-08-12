function pageLoad() {
    checkLogin();
}

function boardSet(){
let Chartas=["I dont exist","A","B","C","D","E","F","G","H"];

    //Pawns
    for(let i=1; i<=8;i++){
        let BSP = Chartas[i]+"2";
        $('#'+BSP).html("&#9817;");
    }for(let i=1; i<=8;i++) {
        let BSP = Chartas[i] + "7";
        $('#' + BSP).html("&#9823;");
    }

    //White Pieces
    for(let i=1; i<=8;i++) {
        let BSP = Chartas[i] + "1";
        if (i==1||i==8){
            $('#' + BSP).html("&#9814;");
        }else if(i==2||i==7){
            $('#' + BSP).html("&#9816;");
        }else if(i==3||i==6){
            $('#' + BSP).html("&#9815;");
        }else if(i==4){
            $('#' + BSP).html("&#9813;");
        }else if(i==5){
            $('#' + BSP).html("&#9812;");
        }
    }
    //Clear Spaces
    for(let i=1; i<=8;i++) {
        for(let c=3;c<=6;c++) {
            let BSP = Chartas[i] + c;
            $('#' + BSP).html("");
        }
    }
}

function checkLogin() {

    let token = Cookies.get("sessionToken");

    if (token === undefined) {
        window.location.href = "/client/login.html";
    } else {
        $.ajax({
            url: '/user/get',
            type: 'GET',
            success: username => {
                if (username === "") {
                    window.location.href = "/client/login.html";
                } else {
                    $("#username").html(username);
                }
            }
        });
    }

    $("#logout").click(event => {
        Cookies.remove("sessionToken");
        window.location.href = "/client/login.html";
    });
}