import styles from "./ButtonGroup.module.css"

export default function ButtonGroup({ children }) {
    return <div className={styles.buttons}>{children}</div>
}
