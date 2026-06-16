# AGENTS.md

## Cursor Cloud specific instructions

This is a plain Java project (JDK 21 is preinstalled on the VM). There is **no build
system** (no Maven/Gradle, no `pom.xml`/`build.gradle`) and **no package manager**, so
there are no dependencies to install. Compilation is done directly with `javac`.

### Build & run

The runnable, self-contained application is `src/Main.java` (default package):

```bash
javac -d out src/Main.java
java -cp out Main
```

`out/` is git-ignored, so it is safe to use as the compile output directory.

### Tests / lint

There are no automated tests and no lint tooling configured in this repo.

### Known caveat: the SkyShop sources do not compile

`src/org/skypro/skyshop/App.java` and `src/basket/ProductBasket.java` reference a class
`org.skypro.skyshop.product.Product` that does not exist. The only `Product` class is
`src/product/Product.java`, which declares `package product;` and is empty (no
constructor/fields/methods). The package declarations also do not match the directory
layout. Compiling the whole tree therefore fails. This is a pre-existing **code defect**,
not an environment/dependency problem — do not treat it as an environment setup issue.
Only `src/Main.java` builds and runs cleanly.
