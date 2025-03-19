
package edu.ucsc.cse118.assignment3.ui.workspaces

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ucsc.cse118.assignment3.R
import edu.ucsc.cse118.assignment3.data.Workspace
import edu.ucsc.cse118.assignment3.databinding.FragmentWorkspacesBinding
import edu.ucsc.cse118.assignment3.model.SharedViewModel
import edu.ucsc.cse118.assignment3.model.ViewModelEvent

class WorkspacesFragment : Fragment(), WorkspacesListener {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    private val errorObserver = Observer<ViewModelEvent<String>> { event ->
        val error = event.getUnhandledContent()
        if (error != null) {
            Toast.makeText(context, "Error: $error", Toast.LENGTH_LONG).show()
        }
    }
    private val workspacesObserver = Observer<ArrayList<Workspace>> { workspaces ->
        recyclerView.adapter = WorkspacesAdapter(workspaces, this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel.error.observe(this, errorObserver)
        sharedViewModel.workspaces.observe(this, workspacesObserver)
    }
    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.error.removeObserver(errorObserver)
        sharedViewModel.workspaces.removeObserver(workspacesObserver)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentWorkspacesBinding.inflate(inflater, container, false)
        return fragmentBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WorkspacesAdapter(arrayListOf(), this)
        sharedViewModel.getWorkspaces()
        sharedViewModel.getMembers()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = sharedViewModel.member.value?.name
    }
    override fun onClick(workspace: Workspace) {
        sharedViewModel.setWorkspace(workspace)
        findNavController().navigate(R.id.action_workspacesFragment_to_channelsFragment)
    }
}