import ComboCard from "./ComboCard";
import styles from "./ComboCards.module.css"

export default function ComboCards({ combos }) {
    return (
        <div className={styles.parent}>
            {combos.map((combo) => <ComboCard key={combo.id} combo={combo} />)}
        </div>
    )
}