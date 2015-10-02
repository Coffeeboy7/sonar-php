/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010 SonarSource and Akram Ben Aissi
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.php.tree.impl;

import com.google.common.collect.Iterators;
import org.sonar.php.tree.impl.expression.IdentifierTreeImpl;
import org.sonar.plugins.php.api.tree.Tree;
import org.sonar.plugins.php.api.tree.expression.IdentifierTree;
import org.sonar.plugins.php.api.tree.expression.VariableIdentifierTree;
import org.sonar.plugins.php.api.visitors.VisitorCheck;

import java.util.Iterator;

public class VariableIdentifierTreeImpl extends PHPTree implements VariableIdentifierTree {

  private final IdentifierTree token;
  private static final Kind KIND = Kind.VARIABLE_IDENTIFIER;


  public VariableIdentifierTreeImpl(IdentifierTreeImpl token) {
    this.token = token;
  }

  @Override
  public Kind getKind() {
    return KIND;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.<Tree>singletonIterator(token);
  }

  @Override
  public void accept(VisitorCheck visitor) {
    visitor.visitVariableIdentifier(this);
  }

  @Override
  public IdentifierTree variableExpression() {
    return token;
  }
}
