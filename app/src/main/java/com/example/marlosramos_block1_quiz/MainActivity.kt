import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.marlosramos_block1_quiz.R

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var radioGroupOperators: RadioGroup
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        radioGroupOperators = findViewById(R.id.radioGroupOperators)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        fun calculateResult() {
            val num1 = editTextNumber1.text.toString().toDouble()
            val num2 = editTextNumber2.text.toString().toDouble()

            val operatorId = radioGroupOperators.checkedRadioButtonId
            val operator = when (operatorId) {
                R.id.radioButtonAdd -> "+"
                R.id.radioButtonSubtract -> "-"
                R.id.radioButtonMultiply -> "*"
                R.id.radioButtonDivide -> "/"
                else -> return
            }
            buttonCalculate.setOnClickListener {
                calculateResult()
            }
        }

        fun performOperation(num1: Double, num2: Double, operator: String): Double {
            return when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> throw IllegalArgumentException("Invalid operator")
            }

            val result = performOperation(num1, num2, operator)
            textViewResult.text = "Result: $result"
        }
    }
}