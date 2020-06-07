function displayform(){
    document.getElementById("hiddenform").style.display="block";
    document.getElementById("import").style.visibility="visible";
    document.getElementById("proceed").style.visibility="hidden";
    document.getElementById("circle1").style.borderColor="#FFD700";
    document.getElementById("circle2").style.borderColor="#FFFFFF";
    document.getElementById("import").style.backgroundColor="#FFD700";
    document.getElementById("proceed").style.backgroundColor="#FFFFFF";
    }

function hideform(){
    document.getElementById("hiddenform").style.display="none";
    document.getElementById("proceed").style.visibility="visible";
    document.getElementById("import").style.visibility="hidden";
    document.getElementById("circle2").style.borderColor="#FFD700";
    document.getElementById("circle1").style.borderColor="#FFFFFF";
    document.getElementById("proceed").style.backgroundColor="#FFD700";
    document.getElementById("import").style.backgroundColor="#FFFFFF";
    }