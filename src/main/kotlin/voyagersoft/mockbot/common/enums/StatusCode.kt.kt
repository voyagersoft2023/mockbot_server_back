package oogaday.commons.enums

enum class StatusCode(val code: Int, val message: String) {
    Continue(100, "테스트 데이터"),

    SwitchingProtocols(101, "101"),
    Processing(102, "102"),

    OK(200, "success"),
    Created(201, "201"),
    Accepted(202, "202"),
    NonAuthoritativeInformation(203, "203"),
    NoContent(204, "204"),
    ResetContent(205, "205"),
    PartialContent(206, "206"),
    MultiStatus(207, "207"),
    AlreadyReported(208, "208"),
    IMUsed(226, "226"),

    MultipleChoices(300, "300"),
    MovedPermanently(301, "301"),
    Found(302, "302"),
    SeeOther(303, "303"),
    NotModified(304, "304"),
    UseProxy(305, "305"),
    TemporaryRedirect(307, "307"),
    PermanentRedirect(308, "308"),

    BadRequest(400, "400"),
    Unauthorized(401, "401"),
    PaymentRequired(402, "402"),
    Forbidden(403, "403"),
    NotFound(404, "404"),
    MethodNotAllowed(405, "405"),
    NotAcceptable(406, "406"),
    ProxyAuthenticationRequired(407, "407"),
    RequestTimeout(408, "408"),
    Conflict(409, "409"),
    Gone(410, "410"),
    LengthRequired(411, "411"),
    PreconditionFailed(412, "412"),
    PayloadTooLarge(413, "413"),
    UriTooLong(414, "414"),
    UnsupportedMediaType(415, "415"),
    RangeNotSatisfiable(416, "416"),
    ExpectationFailed(417, "417"),
    IAmATeapot(418, "418"),
    MisdirectedRequest(421, "421"),
    UnprocessableEntity(422, "422"),
    Locked(423, "423"),
    FailedDependency(424, "424"),
    UpgradeRequired(426, "426"),
    PreconditionRequired(428, "428"),
    TooManyRequests(429, "429"),
    RequestHeaderFieldsTooLarge(431, "431"),
    UnavailableForLegalReasons(451, "451"),

    InternalServerError(500, ""),
    NotImplemented(501, ""),
    BadGateway(502, ""),
    ServiceUnavailable(503, ""),
    GatewayTimeout(504, ""),
    HttpVersionNotSupported(505, ""),
    VariantAlsoNegotiates(506, ""),
    InsufficientStorage(507, ""),
    LoopDetected(508, ""),
    NotExtended(510, ""),
    NetworkAuthenticationRequired(511, ""),

    LoginCheckError(1000, "아이디 또는 비밀번호가 맞지 않습니다."),
    TokenError(1001, "잘못된 토큰 값"),
    IdOverLapCheckError(1002, "중복된 아이디가 존재합니다."),
    NotPhoneNumberError(1003, "존재 하지 않는 휴대폰 번호 입니다."),
    NotAddressError(1004, "회사 정보가 존재하지 않습니다."),
    NotFoundUser(1009, "계정 정보가 올바르지 않습니다."),

    DataError(2000, "데이터 형식이 맞지 않습니다."),
    Unknown(0, "오류");

    /*  fun getErrorCode(): Int = errorCode

      fun getErrorMessage(): String = errorMessage*/

}