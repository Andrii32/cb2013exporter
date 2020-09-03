package domain.nested

import domain.nested.models._


trait DocumentRepository[F[_], Error, Resp, RespBulk] {

    def save(doc: NestedCompany): F[Either[Error, Resp]]

    def save(docs: Seq[NestedCompany]): F[Either[Error, RespBulk]]

}
