<template>
  <div class="full_page_class">

    <div id = "nav_bar_div" hidden>
      <button id = "nav_main_btn" type="text">Main</button>
      <button id = "nav_search_btn" type="text">Search</button>
      <button id = "nav_account_btn" type="text">My Account</button>
      <button id = "nav_plan_btn" type="text">My Plans</button>
      <button id = "nav_ctr_btn" type="text">Complish</button>
    </div>

    <div id = "login_signup_div">
      <h1>{{ msg }}</h1>
      <div class="overlay">
        <p>Please login first: </p >
        <!-- <form action="http://localhost:8079/aaaaa" method="POST" enctype="multipart/form-data"> -->
          <label for="username_input">Username:</label>
          <br>
          <input id="username_input" name="username_input" type="text" required minlength="3" maxlength="20">
          <br>
          <label for="pw_input">Password:</label>
          <br>
          <input id="pw_input" name="pw_input" type="password" required minlength="8" maxlength="20">
          <br><br>
          <button id = "login_btn" type="text">Login</button>
          <br>
          <p>Do not have an account?</p >
          <button id = "signup_btn" type="text">Sign Up</button>
          <br><br>
          <a href=" " target="_blank">Check Google</a >
        <!-- </form> -->
      </div>
    </div>

    <div id = "nav_account_div" hidden>
      <h1>My account</h1>
      <div id = "new_pw_div" hidden>
        <label for="new_pw_input">new Password:</label>
        <br>
        <input id="new_pw_input" name="new_pw_input" type="password" required minlength="8" maxlength="20">
        <br>
        <label for="new_pw_input_confirm">repeat Password:</label>
        <br>
        <input id="new_pw_input_confirm" name="new_pw_input_confirm" type="password" required minlength="8" maxlength="20">
      </div>
      <button id = "new_pw_input_confirm_btn" type="text" hidden>Confirm</button>
      <button id = "change_pwd_btn" type="text">Change password</button>
      <button id = "delete_account_btn" type="text">Delete account</button>
    </div>

    <div id = "con_tr_div" hidden>
      <h1>I have done it!</h1>
      <label for="con_weight_label">My new weight(kg):</label>
      <br>
      <input id="con_weight_input" name="con_weight_input" type="text">
      <button id="con_tr_btn" type="text">Report</button>
    </div>

    <div id = "already_login_div" hidden>
      <h1>You Have Successfully Logged in!</h1>
      <h1 id = "already_login_text">Welcome, Name!</h1>
      <button id = "sign_out_btn" type="text">Sign out</button>
    </div>

    <div id = "signup_div" hidden>
      <h1>You Have Successfully Logged in!</h1>
      <label for="username_signup_input">Username:</label>
      <br>
      <input id="username_signup_input" name="username_signup_input" type="text" required minlength="3" maxlength="20">
      <br>
      <label for="password_signup_input">Password:</label>
      <br>
      <input id="password_signup_input" name="password_signup_input" type="text" required minlength="8" maxlength="20">
      <br>
      <label for="email_signup_input">Email:</label>
      <br>
      <input id="email_signup_input" name="email_signup_input" type="text" required minlength="3" maxlength="25">
      <br>
      <label for="age_signup_input">Age:</label>
      <br>
      <input id="age_signup_input" name="age_signup_input" type="number">
      <br>
      <label for="gender_signup_input">Gender:</label>
      <br>
      <select id="gender_signup_input" name="gender_signup_input">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
      </select>
      <br>
      <label for="weight_signup_input">Weight(kg):</label>
      <br>
      <input id="weight_signup_input" name="weight_signup_input" type="number">
      <br>
      <label for="height_signup_input">Height(cm):</label>
      <br>
      <input id="height_signup_input" name="height_signup_input" type="number">
      <br>



      <label for="goal_signup_input">Goal:</label>
      <br>
      <select id="goal_signup_input_first" name="goal_signup_input">
        <option value="Weight loss">Weight loss</option>
        <option value="Muscle Build">Muscle Build</option>
      </select>
      <select id="goal_signup_input_second" name="goal_signup_input">
        <option value="5kg">5kg</option>
        <option value="10kg">10kg</option>
        <option value="15kg">15kg</option>
        <option value="20kg">20kg</option>
      </select>



      <br>
      <label for="fitnessLevel_signup_input">FitnessLevel:</label>
      <br>
      <select id="fitnessLevel_signup_input" name="fitnessLevel_signup_input">
        <option value="Sedentary">Sedentary</option>
        <option value="Lightly_Active">Lightly Active</option>
        <option value="Moderately_Active">Moderately Active</option>
        <option value="Very_Active">Very_Active</option>
        <option value="Extra_Active">Extra Active</option>
      </select>
      <br>
      <label for="gymAccess_signup_input">Gym Access:</label>
      <br>
      <select id="gymAccess_signup_input" name="gymAccess_signup_input">
        <option value=0>No</option>
        <option value=1>Yes</option>
      </select>
      <br>
      <label for="timeAvaliable_signup_input">Time Avaliable:</label>
      <br>
      <input id="timeAvaliable_signup_input" name="timeAvaliable_signup_input" type="number">
      <br>
      <button id = "signup_signup_btn" type="text">Sign Up</button>
      <br>
      <button id = "signup_cancel_btn" type="text">Go back</button>
      <br>
    </div>


    <div id="search_div" hidden>
      <br>
      <label for="search_input">Type keyword for moves:</label>
      <br>
      <input id="search_input" name="search_input" type="text">
      <button id="search_btn" type="text">Search</button>
      <h3>Related Moves:</h3>
      <h3 id="search_text"></h3>
      <br>
      <button id="max_age_btn" type="text">Age Button</button>
      <h3>Accounts with the highest age number:</h3>
      <h3 id="max_age_text"></h3>
      <br>
      <button id="magic_btn" type="text">Magic Button</button>
      <h3>Highest muscle build with highest estTime:</h3>
      <h3 id="magic_text"></h3>
      <br>
      <button id="magic_btn" type="text">Magic Button</button>
      <h3>Highest muscle build with highest estTime:</h3>
      <h3 id="magic_text"></h3>
      <br><br>
    </div>

    <div id="plan_div" hidden>
      <h3>My Plans (Generated according to demands):</h3>
      <h3 id="plan_text"></h3>
      <br>
      <button id="ge_plan_btn" type="text">Generate a plan</button>
      <button id="de_plan_btn" type="text">Clear all plans</button>
      <br>
      <br><br>
    </div>



  </div>


</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #00308f;
}
button {
  margin: 10px;
}
.full_page_class {
  background-image: url('../assets/background_silver.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>