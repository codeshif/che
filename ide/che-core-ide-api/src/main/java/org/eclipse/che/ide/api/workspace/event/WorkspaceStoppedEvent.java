/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.api.workspace.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import org.eclipse.che.api.core.model.workspace.Workspace;
import org.eclipse.che.ide.api.app.AppContext;

/** Fired when the current workspace goes into a stopped state. */
public class WorkspaceStoppedEvent extends GwtEvent<WorkspaceStoppedEvent.Handler> {

    public static final Type<WorkspaceStoppedEvent.Handler> TYPE = new Type<>();

    private final Workspace workspace;
    private final boolean   error;
    private final String    errorMessage;

    public WorkspaceStoppedEvent(Workspace workspace, boolean error, String errorMessage) {
        this.workspace = workspace;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    /** @deprecated use {@link AppContext#getWorkspace()} */
    @Deprecated
    public Workspace getWorkspace() {
        return workspace;
    }

    public boolean isError() {
        return error;
    }

    /**
     * Returns an error message if workspace was stopped due to error.
     *
     * @return error message if workspace was stopped due to error
     * or an empty string if workspace was stopped normally
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Type<WorkspaceStoppedEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(WorkspaceStoppedEvent.Handler handler) {
        handler.onWorkspaceStopped(this);
    }

    public interface Handler extends EventHandler {
        void onWorkspaceStopped(WorkspaceStoppedEvent event);
    }
}
