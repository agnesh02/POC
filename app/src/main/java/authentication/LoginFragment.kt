package authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poc.R
import com.example.poc.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: AuthenticationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this)[AuthenticationViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.errorCode.observe(viewLifecycleOwner, Observer {
            if (it == 2) {
                binding.etLoginEmailId.error = "Please enter a valid E-mail id"
                return@Observer
            }
            if (it == 3) {
                binding.etLoginPassword.error = "Please enter a password having 6 to 10 characters"
                return@Observer
            }
        })

        viewModel.loginStatus.observe(viewLifecycleOwner) {
            if(it) {
                binding.progressBarLogin.visibility = View.INVISIBLE
                activity?.finish()
            }
        }

        binding.tvLoginGoToRegister.setOnClickListener {
            fragmentChange(RegistrationFragment())
        }

        binding.tvLoginResetPassword.setOnClickListener {
            fragmentChange(ResetPasswordFragment())
        }

        return binding.root
    }

    private fun fragmentChange(fragment: Fragment) {
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_authentication, fragment).commit()
    }


}