function pageLoad() {
    checkLogin();
}

function boardSetChess(){
    //To use for columns
    let Chartas=["I don't exist","A","B","C","D","E","F","G","H"];

    //Pawns
    for(let i=1; i<=8;i++){
        //White
        let BSP = Chartas[i]+"2";
        $('#'+BSP).html("&#9817;");
    }for(let i=1; i<=8;i++) {
        //Black
        let BSP = Chartas[i] + "7";
        $('#' + BSP).html("&#9823;");
    }

    //White Pieces
    for(let i=1; i<=8;i++) {
        let BSP = Chartas[i] + "1";
        if (i===1||i===8){
            //Rook
            $('#' + BSP).html("&#9814;");
        }else if(i===2||i===7){
            //Knight
            $('#' + BSP).html("&#9816;");
        }else if(i===3||i===6){
            //Bishop
            $('#' + BSP).html("&#9815;");
        }else if(i===4){
            //Queen
            $('#' + BSP).html("&#9813;");
        }else if(i===5){
            //King
            $('#' + BSP).html("&#9812;");
        }
    }

    //Black Pieces
    for(let i=1; i<=8;i++) {
        let BSP = Chartas[i] + "8";
        if (i===1||i===8){
            //Rook
            $('#' + BSP).html("&#9820;");
        }else if(i===2||i===7){
            //Knight
            $('#' + BSP).html("&#9822;");
        }else if(i===3||i===6){
            //Bishop
            $('#' + BSP).html("&#9821;");
        }else if(i===4){
            //Queen
            $('#' + BSP).html("&#9819;");
        }else if(i===5){
            //King
            $('#' + BSP).html("&#9818;");
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

function boardSetCheckers(){
    //To use for columns
    let Chartas=["I don't exist","A","B","C","D","E","F","G","H"];

    //White
    for(let i=1;i<=8;i++){
        for(let j=1;j<=3;j++) {
            let BSP = Chartas[i] + j;
            if (j % 2 === 1 && i % 2 === 1) {
                $('#' + BSP).html("&#9920;");
            } else if (j===2&&i%2===0){
                $('#' + BSP).html("&#9920;");
            }else{
                $('#' + BSP).html("");
            }
        }
    }

    //Black
    for(let i=1;i<=8;i++){
        for(let j=6;j<=8;j++) {
            let BSP = Chartas[i] + j;
            if (j % 2 === 0 && i % 2 === 0) {
                $('#' + BSP).html("&#9922;");
            } else if (j===7&&i%2===1){
                $('#' + BSP).html("&#9922;");
            }else{
                $('#' + BSP).html("");
            }
        }
    }

    //Blank Space
    for(let i=1;i<=8;i++){
        for(let j=4;j<=5;j++) {
            $('#' + Chartas[i] + j).html("");
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