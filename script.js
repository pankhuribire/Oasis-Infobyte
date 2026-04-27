// SAVED PASSWORD

let savedPassword =localStorage.getItem("password") || "1234";
function login() {
    
    let u= document.getElementById("username").value;
    
    let p= document.getElementById("password").value;

    if(u==="student" && p=== savedPassword) {
        alert("Login Successful");
        window.location.href="exam.html";
    }
    else{
        alert("Wrong Username or Password");
    }
}

// CHANGE PASSWORD

function changePassword()
{
    let newPass = promt("Enter new password");
    if(newPass)
    {
        localStorage.setItem("password",newPass);
        alert("Password Changed");
    }
}

// TIMER
let time = 20*60;

let timer = setInterval(function() {
    let t= document.getElementById("time");
    if(t) 
    {
        let minutes = Math.floor(time/60);
        let seconds = time%60;
            seconds=seconds < 10 ? "0"+seconds :seconds;
        t.innerText = minutes + ":" + seconds;
        time--;
        
        if(time<60){
            t.style.color="red";
        }

        if(time < 0)
        {
            clearInterval(timer);
            alert("Time's up!");
            SubmitExam();
        }
    }
},1000);


// SUBMIT EXAM
function SubmitExam() 
{
    let score=0;

    let q1= document.querySelector('input[name="q1"]:checked');
    let q2= document.querySelector('input[name="q2"]:checked');
    let q3= document.querySelector('input[name="q3"]:checked');
    let q4= document.querySelector('input[name="q4"]:checked');
    let q5= document.querySelector('input[name="q5"]:checked');
    let q6= document.querySelector('input[name="q6"]:checked');
    let q7= document.querySelector('input[name="q7"]:checked');
    let q8= document.querySelector('input[name="q8"]:checked');
    let q9= document.querySelector('input[name="q9"]:checked');
    let q10= document.querySelector('input[name="q10"]:checked');

    if(q1 && q1.value == "a") score++ ;
    if(q2 && q2.value == "a") score++ ;
    if(q3 && q3.value == "b") score++ ;
    if(q4 && q4.value == "b") score++ ;
    if(q5 && q5.value == "b") score++;
    if(q6 && q6.value == "a") score++; 
    if(q7 && q7.value == "b") score++ ;
    if(q8 && q8.value == "b") score++ ;
    if(q9 && q9.value == "a") score++ ;
    if(q10 && q10.value == "a") score++ ;

    localStorage.setItem("score",score);

    let blob = new Blob([score.toString()], {
        type:"text/plain"
    });
    let link = document.createElement("a");
    link.href= URL.createObjectURL(blob);
    link.download = "score.txt";
    link.click();
    

    window.location.href = "result.html";
}