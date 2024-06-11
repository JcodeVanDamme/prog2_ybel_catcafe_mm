package catcafe;

import static java.util.Objects.requireNonNull;

import java.util.Optional;
import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

/** Tree structure implementing {@link Tree} holding {@link FelineOverLord}. */
public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    /** Default constructor for CatCafe. Initializes an empty tree of FelineOverLords. */
    public CatCafe() {}

    /**
     * Adds a Cat to the Tree.
     *
     * @param cat to add
     */
    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    /**
     * Get the Number of Elements in the Tree.
     *
     * @return Size of the Tree
     */
    public long getCatCount() {
        return clowder.size();
    }

    /**
     * Search the Tree for a Cat named @param
     *
     * @param name of the Cat to be searched for
     * @return Optional.of.Nullable(FelineOverlord) if the Cat was found, Optional.empty() if not
     */
    public Optional<FelineOverLord> getCatByName(String name) {
        if (name == null || clowder.isEmpty()) {
            return Optional.empty();
        }
            return clowder.stream().filter(c -> c.name().equals(name)).findFirst();
    }

    /**
     * Search the Tree for a Cat with a weigth specified by @param
     *
     * @param minWeight lower Bounds of a Cats weight to be searched for
     * @param maxWeight upper Bounds of a Cats weight to be searched for
     * @return Optional.of.Nullable(FelineOverlord) in the given weightrange, Optional.empty() if
     *     not
     */
    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0 || maxWeight < minWeight || clowder.isEmpty()) {
            return Optional.empty();
        }

        return clowder.stream()
                .filter(c -> c.weight() >= minWeight)
                .filter(c -> c.weight() <= maxWeight)
                .findFirst();
    }

    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
