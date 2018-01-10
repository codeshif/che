/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.git.client.panel;

/** @author Mykola Morhun */
public interface RepositoryNodeFactory {
  /**
   * Creates new repository entry.
   *
   * @param repository repository name
   * @param changes number of changed file in the repository
   */
  RepositoryNode newRepositoryNode(String repository, int changes);
}