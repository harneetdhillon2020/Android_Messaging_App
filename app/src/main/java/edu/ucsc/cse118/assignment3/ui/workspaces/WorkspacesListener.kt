package edu.ucsc.cse118.assignment3.ui.workspaces

import edu.ucsc.cse118.assignment3.data.Workspace

interface WorkspacesListener {
    fun onClick(workspace: Workspace)
}