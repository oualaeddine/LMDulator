package dz.da3sou9a.oualaeddine.lmdulator.activities.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.ButterKnife;
import dz.da3sou9a.oualaeddine.lmdulator.R;
import dz.da3sou9a.oualaeddine.lmdulator.activities.Launcher;
import dz.da3sou9a.oualaeddine.lmdulator.db.UsersTableManager;
import dz.da3sou9a.oualaeddine.lmdulator.items.User;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @Bind(R.id.input_email)
    EditText _emailText;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    @Bind(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_imported);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        final User loggedUser = new User();

        loggedUser.setUserName(email);
        loggedUser.setPassword(password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess(loggedUser);
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful sigin logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(User loggedUser) {
        _loginButton.setEnabled(true);

        Intent intent = new Intent(getApplicationContext(), Launcher.class);

        intent.putExtra("loggedUserName", (Serializable) loggedUser.getUserName());
        UsersTableManager usersTableManager = new UsersTableManager(getApplicationContext());
        usersTableManager.open();
        String email = _emailText.getText().toString();

        int userId = usersTableManager.getUserIdByName(email);
        intent.putExtra("userId", userId);

        startActivity(intent);

        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        //TODO: test if the user exists in db


        if (email.isEmpty()/** || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()**/) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        UsersTableManager db = new UsersTableManager(getApplicationContext());
        db.open();
        if (db.isUser(email) && db.getPasswordByName(email) == password) {
            valid = true;
        } else {
            if (!db.getPasswordByName(email).equals(password)) {
                Toast.makeText(getBaseContext(), "wrong password true pass is:" + db.getPasswordByName(email) + " entered " + password, Toast.LENGTH_LONG).show();
                _passwordText.setError("wrong password");
                valid = false;
            }
            if (!db.isUser(email)) {
                Toast.makeText(getBaseContext(), "Wrong userame ", Toast.LENGTH_LONG).show();
                _emailText.setError("wrong username");
                valid = false;
            }
        }
        return valid;
    }
}
