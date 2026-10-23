package com.luigi.task.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.luigi.task.R
import com.luigi.task.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return  binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Autenticação com o serviço Firebase
        auth = FirebaseAuth.getInstance()


        Handler(Looper.getMainLooper()).postDelayed({checkAuth()}, 3000)
    }

    private fun checkAuth(){
        try {
            //representa o usuario autenticado no Firebase
            val currtUser = auth.currentUser

            if(currtUser!=null){
                //logado
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                //deslogado
                findNavController().navigate(R.id.action_splashFragment_to_autheticantion)
            }

        }catch (e: Exception){
            Toast.makeText(requireContext(),e.message.toString(), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_splashFragment_to_authetication)
        }
        findNavController().navigate(R.id.action_splashFragment3_to_authentication)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}