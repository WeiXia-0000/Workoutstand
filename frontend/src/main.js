import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app');


const nav_account_btn = document.getElementById("nav_account_btn");
const nav_plan_btn = document.getElementById("nav_plan_btn");
const login_btn = document.getElementById("login_btn");
const signup_btn = document.getElementById("signup_btn");
const signup_signup_btn = document.getElementById("signup_signup_btn");
const sign_out_btn = document.getElementById("sign_out_btn");
const change_pwd_btn = document.getElementById("change_pwd_btn");
const delete_account_btn = document.getElementById("delete_account_btn");
const signup_cancel_btn = document.getElementById("signup_cancel_btn");
const search_btn = document.getElementById("search_btn");
const max_age_btn = document.getElementById("max_age_btn");
const magic_btn = document.getElementById("magic_btn");
const nav_search_btn = document.getElementById("nav_search_btn");
const nav_main_btn = document.getElementById("nav_main_btn");
const new_pw_input_confirm_btn = document.getElementById("new_pw_input_confirm_btn");
const ge_plan_btn = document.getElementById("ge_plan_btn");
const de_plan_btn = document.getElementById("de_plan_btn");
const nav_ctr_btn = document.getElementById("nav_ctr_btn");
const con_tr_btn = document.getElementById("con_tr_btn");


const already_login_text = document.getElementById("already_login_text");

const login_signup_div = document.getElementById("login_signup_div");
const already_login_div = document.getElementById("already_login_div");
const signup_div = document.getElementById("signup_div");
const nav_bar_div = document.getElementById("nav_bar_div");
const nav_account_div = document.getElementById("nav_account_div");
const new_pw_div = document.getElementById("new_pw_div");
const search_div = document.getElementById("search_div");
const plan_div = document.getElementById("plan_div");
const con_tr_div = document.getElementById("con_tr_div");




//for account info:
//var login_status = 0;
var userName = "";
var user_id = 0;
var get_demand_time = "1";
//var password = "";

login_btn.addEventListener("click", function() {
  var username_input = document.getElementById("username_input").value;
  var pw_input = document.getElementById("pw_input").value;
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      console.log(response);
      if (response == "") {
        // login didn't work:
        window.alert("Your username or password was incorrect. Please try again.");
      } else {
        // login successfully:
        login_signup_div.hidden = true;
        already_login_div.hidden = false;
        nav_bar_div.hidden = false;

        var response_json = JSON.parse(response);
        userName = response_json.userName;
        user_id = response_json.User_id;
        console.log(user_id);

        already_login_text.textContent = userName;
        //login_status = 1;
      }
    }
  };
  xhr.open("POST", "http://localhost:8082/login_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify({"username": username_input, "password": pw_input}));
});

nav_account_btn.addEventListener("click", function() {
  nav_account_div.hidden = false;
  delete_account_btn.hidden = false;
  change_pwd_btn.hidden = false;
  already_login_div.hidden = true;
  new_pw_div.hidden = true;
  new_pw_input_confirm_btn.hidden = true;
  plan_div.hidden = true;
  search_div.hidden = true;
  con_tr_div.hidden = true;
});
nav_plan_btn.addEventListener("click", function() {
  signup_div.hidden = true;
  login_signup_div.hidden = true;
  nav_account_div.hidden = true;
  search_div.hidden = true;
  already_login_div.hidden = true;
  con_tr_div.hidden = true;
  plan_div.hidden = false;

});

nav_search_btn.addEventListener("click", function() {
  signup_div.hidden = true;
  login_signup_div.hidden = true;
  already_login_div.hidden = true;
  nav_account_div.hidden = true;
  plan_div.hidden = true;
  con_tr_div.hidden = true;
  search_div.hidden = false;
});

nav_main_btn.addEventListener("click", function() {
  signup_div.hidden = true;
  login_signup_div.hidden = true;
  nav_account_div.hidden = true;
  search_div.hidden = true;
  plan_div.hidden = true;
  con_tr_div.hidden = true;
  already_login_div.hidden = false;
});

nav_ctr_btn.addEventListener("click", function() {
  signup_div.hidden = true;
  login_signup_div.hidden = true;
  nav_account_div.hidden = true;
  search_div.hidden = true;
  plan_div.hidden = true;
  already_login_div.hidden = true;
  con_tr_div.hidden = false;
});

signup_cancel_btn.addEventListener("click", function() {
  login_signup_div.hidden = false;
  signup_div.hidden = true;
});

signup_btn.addEventListener("click", function() {
    signup_div.hidden = false;
    login_signup_div.hidden = true;
});

signup_signup_btn.addEventListener("click", function() {
    let gender_select = document.getElementById('gender_signup_input');
    let goal_select_first = document.getElementById('goal_signup_input_first');
    let goal_select_second = document.getElementById('goal_signup_input_second');
    let fitness_level_select = document.getElementById('fitnessLevel_signup_input');
    let gym_acess_select = document.getElementById('gymAccess_signup_input');
    var username_input = document.getElementById("username_signup_input").value;
    var pw_input = document.getElementById("password_signup_input").value;
    var email_input = document.getElementById("email_signup_input").value;
    var age_input = document.getElementById("age_signup_input").value;
    var gender_input = gender_select.value;
    console.log(gender_input);
    var weight_input = document.getElementById("weight_signup_input").value;
    var height_input = document.getElementById("height_signup_input").value;
    var goal_input_first = goal_select_first.value;
    console.log(goal_input_first);
    var goal_input_second = goal_select_second.value;
    var fitness_level_input = fitness_level_select.value;
    var gym_acess_input = gym_acess_select.value;
    var time_acess_input = document.getElementById("timeAvaliable_signup_input").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8082/sign_up_post", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(
      {"username": username_input,
       "password": pw_input,
       "email": email_input,
       "age":age_input,
       "gender": gender_input,
       "weight": weight_input,
       "height": height_input,
       "goal_first": goal_input_first,
       "goal_second": goal_input_second,
       "fitnessLevel":fitness_level_input,
       "gymAccess": gym_acess_input,
       "timeAvailable":time_acess_input,
      }
    ));
    signup_div.hidden = true;
    login_signup_div.hidden = false;
});

change_pwd_btn.addEventListener("click", function() {
  new_pw_div.hidden = false;
  new_pw_input_confirm_btn.hidden = false;
  change_pwd_btn.hidden = true;
  delete_account_btn.hidden = true;
});

new_pw_input_confirm_btn.addEventListener("click", function() {
  var new_pw_input = document.getElementById("new_pw_input").value;
  var new_pw_input_confirm = document.getElementById("new_pw_input_confirm").value;
  console.log(new_pw_input);
  console.log(new_pw_input_confirm);
  if (new_pw_input != new_pw_input_confirm) {
    window.alert("Possward not match");
  } else {
    var xhrr = new XMLHttpRequest();
    xhrr.onreadystatechange = function() {
      if (xhrr.readyState == 4 && xhrr.status == 200) {
        var response = xhrr.responseText;
        if (response == "") {
          // change password didn't work:
          window.alert("No user found");
        } else {
          // change password successfully:
          new_pw_div.hidden = true;
          new_pw_input_confirm_btn.hidden = true;    
          nav_account_div.hidden = true;
          
          change_pwd_btn.hidden = false;
          delete_account_btn.hidden = false;
          already_login_div.hidden = false; 
        }
      }
    };
    xhrr.open("POST", "http://localhost:8082/change_password_post", true);
    xhrr.setRequestHeader('Content-Type', 'application/json');
    xhrr.send(JSON.stringify({"User_id": user_id, "new_password": new_pw_input}));
  }
});

sign_out_btn.addEventListener("click", function() {
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8082/sign_out_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send();
  //login_status = 0;
  login_signup_div.hidden = false;
  already_login_div.hidden = true;
});

delete_account_btn.addEventListener("click", function() {
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8082/delete_account_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(JSON.stringify({"User_id": user_id}));
  //login_status = 0;
  login_signup_div.hidden = false;
  nav_account_div.hidden = true;
});

search_btn.addEventListener("click", function() {
  var search_input = document.getElementById("search_input").value;
  if (search_input == "") {
    window.alert("Please type keyword!");
    return;
  }
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      if (response == "") {
        window.alert("No matching keyword was found!");
      } else {
        document.getElementById("search_text").textContent = response;
      }
    }
  };
  xhr.open("POST", "http://localhost:8082/search_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(search_input);
});


max_age_btn.addEventListener("click", function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      if (response == "") {
        window.alert("No account exists in database!");
      } else {
        document.getElementById("max_age_text").textContent = response;
      }
    }
  };
  xhr.open("POST", "http://localhost:8082/max_age_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send();
});

magic_btn.addEventListener("click", function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      if (response == "") {
        window.alert("No account exists in database!");
      } else {
        document.getElementById("magic_text").textContent = response;
      }
    }
  };
  xhr.open("POST", "http://localhost:8082/magic_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send();
});


ge_plan_btn.addEventListener("click", function() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      if (response == "") {
        window.alert("No matching keyword was found!");
      } else {
        var response_json = JSON.parse(response);
        console.log(response);
        document.getElementById("plan_text").textContent += response_json.plan;
        document.getElementById("plan_text").textContent += "\n";
        get_demand_time = response_json.get_demand_time;
      }
    }
  };

  console.log(get_demand_time);

  xhr.open("POST", "http://localhost:8082/ge_plan_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(get_demand_time);
});

de_plan_btn.addEventListener("click", function() {
  document.getElementById("plan_text").textContent = "";
  get_demand_time = 1;
});

con_tr_btn.addEventListener("click", function() {
  var new_weight = document.getElementById("con_weight_input").value;
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      var response = xhr.responseText;
      if (response == "1") {
        window.alert("Congratulations! You have achieved your goal!");
      } else {
        window.alert("Sorry, but you have not achieved your goal yet. Good effort. Keep working!");
      }
    }
  };
  xhr.open("POST", "http://localhost:8082/new_weight_post", true);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.send(new_weight);
});

