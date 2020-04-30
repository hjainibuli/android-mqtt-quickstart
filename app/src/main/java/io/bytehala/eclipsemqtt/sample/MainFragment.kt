package io.bytehala.eclipsemqtt.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.old_activity_main.*
import java.util.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.old_activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addConnectionFab.setOnClickListener {
            findNavController().navigate(R.id.action_new_connection)
        }

        val arrayAdapter = ArrayAdapter<Connection>(
            requireContext(),
            R.layout.old_connection_text_view
        )
        list.adapter = arrayAdapter

        // get all available connections

        // get all available connections
        val connections =
            Connections.getInstance(requireContext())
                .connections


        if (connections != null) {
            val cons: List<String?> =
                ArrayList(connections.keys)
            Collections.reverse(cons)
            for (s in cons) {
                arrayAdapter.add(connections[s])
            }
        }
    }

}