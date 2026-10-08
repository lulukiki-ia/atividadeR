package com.luigi.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.luigi.task.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loginUser(email: String, passoword: String){
        try {
            auth.signInWithEmailPassoword(email, passoword)
                .addOnCompleteListener { task ->
                    //entrada do evento
                    task ->
                    //execução do evento
                    if(task.isSuccessful){
                        //Conseguiu autenticar com sucesso
                        findNavController().navigate(R.id.action_global_homeFragment)
                    }else{
                        //Ocorreu falha na autenticação
                        Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }
        }catch(e: Exception){
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    private fun validateDate(){
        val email = binding.editEmail.txt
    }

}