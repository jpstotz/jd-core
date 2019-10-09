/*
 * Copyright (c) 2008, 2019 Emmanuel Dupuy.
 * This project is distributed under the GPLv3 license.
 * This is a Copyleft license that gives the user the right to use,
 * copy and modify the code freely for non-commercial purposes.
 */

package org.jd.core.v1.model.javasyntax.type;

public class WildcardExtendsTypeArgument implements TypeArgument {
    protected Type type;

    public WildcardExtendsTypeArgument(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(TypeArgumentVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isTypeArgumentAssignableFrom(BaseTypeArgument typeArgument) {
        if (typeArgument.getClass() == WildcardExtendsTypeArgument.class) {
            return type.isTypeArgumentAssignableFrom(((WildcardExtendsTypeArgument)typeArgument).getType());
        } else if (typeArgument instanceof Type) {
            return type.isTypeArgumentAssignableFrom(typeArgument);
        }

        return false;
    }

    @Override
    public String toString() {
        return "WildcardExtendsTypeArgument{? extends " + type + "}";
    }
}
